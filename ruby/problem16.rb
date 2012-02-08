def sum_digits(num)
  sum = 0
  num.to_s.split(//).each {|part|
    sum += part.to_i
  }
  
  sum
end

if __FILE__ == $0
  puts sum_digits(2**1000)
end