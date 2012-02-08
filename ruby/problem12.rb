require 'lib/math.rb'
#require 'profile'
#require 'ruby-prof'

def triangle(number)
  sum = 0
  while number > 0 do
    sum += number
    number -= 1;
  end
  sum
end

def num_divisors(number)
  divs = 1
  
  for i in (1..(number/2))
    if number%i == 0
#      if $cache != nil && $cache[i] != nil && $cache[i]+divs < 400
      #      if i > 100
      #        puts "Cache hit at #{i} (#{$cache[i]})!"
      #      end
#        break
#      end
    
      divs += 1
    end
  end

  return divs
end

def num_divisors_sqrt(number)
  return 1 if number == 1
  return 2 if number == 2
  
  divs = 0
  
  for i in (1..(Math.sqrt(number)))
    if number%i == 0
      divs += 2
    end
  end

  return divs
end

def num_divisors_by_all_primes(number)
  # Standard divisors
  divs = [1, number]
  
#  puts "number is #{number}"
  
  # Get all divisors by taking all prime divisors
  prime_divs = all_prime_divisors(number)

#  puts "prime divs #{prime_divs.inspect}"

  # and the multiples of them that are divisors
  prime_divs.each {|prime|
    i = 1
    while prime*i < number
      divs << prime*i if number % (prime*i) == 0
      i = i+1
    end
  }

#  puts "divs are #{divs.inspect}"
  
  # now we have all divisors
  divs.uniq.length
end

def all_prime_divisors(number)
  # Find all divisors of number that are primes
  primes = get_primes_upto(number/2)
  prime_divs = []
  primes.each {|prime|
    prime_divs << prime if number%prime == 0
  }
  
  prime_divs
end

def get_primes_upto(max)
  # list of primes is global
  $primes = [2] if $primes == nil
  
  # add only primes to the list that have not been found yet
#  puts "upto max #{max}"
#  puts "-primes #{$primes.inspect}"
  ($primes[-1]+1 > 3 ? $primes[-1]+1 : 3).upto(max) {|n|
#    puts "-checking #{n}"
    $primes << n if prime2? n
  }
  
  # return only under requested max
  $primes.select {|n| n <= max }
end

def prime2?(number)
  $primes = [2] if $primes == nil

#  return true if $primes.index number

#  puts "primes #{$primes.inspect}"
  $primes.each {|prime|
    return true if number == prime
    return false if number % prime == 0
  }
  
  # check non-cached primes one by one
  ($primes[-1]+1).upto(number/2) {|n|
    if (number % n == 0)
      return false
    end
  }
  
  true
end

def prime?(number)
  (2..number/2).each {|n|
    if (number % n == 0)
      return false
    end
  }
  
  true
end

def num_divisors_by_prime(number)
  return 1 if number == 1
  
  next_num = number
  prime_divs = []
  
  loop do
    # find smallest prime that number is divisible by
    prime_div = smallest_prime_divisor(next_num)
  
    # add to divisors
    prime_divs << prime_div    
    break if prime_div == next_num
    next_num = next_num / prime_div
  end

  # get powerset of divisors
  puts "prime divs #{prime_divs.length} #{prime_divs.inspect}"
  ps_divs = powerset(prime_divs).uniq
#  puts "powerset(#{prime_divs.inspect}) length: #{ps_divs.length}"

  # no use for empty set
  ps_divs.delete []
  
  # calc products of powerset
  products_ps_divs = ps_divs.collect { |set|
    set.inject(1) { |product, n|
      product * n
    }
  }
  
  # add identity
  products_ps_divs << 1
  
  # those are the divisors, now the the number
  products_ps_divs.length
end

# This is not really a powerset()
# Since this version should accept duplicates and build a powerset from that
def powerset(set)
#  return $ps_cache[set] if $ps_cache[set] != nil
  return [[]] if set == []
  return [[], [set[0]]] if set.length == 1
  return [[], [set[0]], [set[1]], [set[0], set[1]]] if set.length == 2
  
  result = [set]

#  puts "powerset() at length #{set.length}"
#  set.each_index { |i|
  i = 0
  l = set.length
  while i < l
      set2 = set.clone
      set2.delete_at i
      result += powerset(set2)
      i += 1
  end
#  }
  
#  $ps_cache[set] = result if set.flatten.length <= 3
  result
end

def powerset_sequential(set)
  groups = [[]]
  
  puts "********************"
  puts "input #{set.inspect}"
  
  set.each {|n|
    groups[0] << [n]
  }

  puts "groups #{groups.inspect}"

  # repeat until all groups have been formed
  new_group = groups[0]
  while groups.length < set.length do
#    new_group = []
#    puts "-group #{group.inspect}"
#  
#    # for each element of the group (expect the last)
#    0.upto(group.length-2) {|i|
#      puts "--group i #{i} = #{group[i].inspect}"
#      # combine with all next elements (only combinations not done yet)
#      (i+1).upto(group.length-1) {|j|
#        puts "--group j #{j} = #{group[j].inspect}"
#        new_group << group[i] + group[j]
#      }
#    }

    # match the last group against the first group
    groups[0].each {|i|
      puts "--group i #{i} = #{group[i].inspect}"
      (i+1).upto(group.length-1) {|j|
        puts "--group j #{j} = #{group[j].inspect}"
        new_group << group[i] + group[j]
      }
    }

    puts "-new group #{new_group.inspect}"
    groups << new_group
  end

  puts "groups #{groups.inspect}"
  
  ps = [[]]
  groups.each {|group|
    group.each {|elem|
      ps << elem
    }
  }
  
  puts "powerset #{ps.inspect}"
  
  ps
end

def smallest_prime_divisor(number)
  (2..number/2+1).each {|n|
    if number%n == 0 && prime?(n)
      return n
    end
  }
  
  number
end

def all_combinations(values)
  (1..values.size).each {|n|
    puts "Testing all combinations of #{n}"
    
  }
end

if __FILE__ == $0
  puts "starting look for triangle number with over 500 divisors"
  
  # 1007 is long
  
  start = Time.now
#  RubyProf.start
  $cache = []
  $ps_cache = {}
  i = 2050
  divs = 0
  biggest_div = {'num' => 2, 'divs' => 2}
  while divs <= 500 do
    i += 1
    num = triangle(i)
#    divs = num_divisors(num)
    divs = num_divisors_sqrt(num)
#    divs = num_divisors_by_prime(num)
#    divs = num_divisors_by_all_primes(num)
    
    # Put all results in cache since the loop will
    # terminate at the requested result
#    $cache[num] = divs
    
    if divs > biggest_div['divs']
        biggest_div['num'] = num
        biggest_div['divs'] = divs
        puts "#{i} = #{num} (#{divs})"
    end
  end
  
  puts "Elapsed #{Time.now - start} seconds"
#  puts "powerset cache size: #{$ps_cache.length}"
  
#  result = RubyProf.stop

  # Print a flat profile to text
#  printer = RubyProf::FlatPrinter.new(result)
#  printer.print(STDOUT, 0)
end