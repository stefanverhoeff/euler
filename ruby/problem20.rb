def sum_digits(num)
  sum = 0
  num.to_s.split(//).each {|part|
    sum += part.to_i
  }
  
  sum
end

def factorial(n)
  if n == 1
    return 1
  end
  
  n * (factorial(n-1))
end

if __FILE__ == $0
  puts sum_digits(factorial(100))
end