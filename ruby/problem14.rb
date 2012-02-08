def next_n(n)
  return n/2 if n%2 == 0
  3*n+1
end

def chain(start)
  the_chain_size = 1
  n = start
  
  while n != 1
    if $lut[n] != nil && $lut[n] + the_chain_size < $largest_size
      the_chain_size += $lut[n]
      break
    end
  
    n = n%2==0 ? n/2 : 3*n+1
    the_chain_size += 1
    $loops+=1
  end
  
  $lut[start] = the_chain_size
end

def find_largest_chain_until(max)
  $largest_size = 0
  largest_num = 0
#  percent = (max/100).floor
  
  (2..max).each {|start|
#    next if $lut[start] != nil
  
    a_chain_size = chain(start)
    
    if a_chain_size > $largest_size
      $largest_size = a_chain_size
      largest_num = start
    end
  }
  
  largest_num
end

$loops = 0
$lut = {}

if __FILE__ == $0
  largest = find_largest_chain_until(1_000_000)
  p largest
end