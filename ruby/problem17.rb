def say_number(num)
  ones = %w{ q one two three four five six seven eight nine }
  tentotwenties = %w{ ten eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen nineteen }
  tens = %w{ q q twenty thirty forty fifty sixty seventy eighty ninety }
  said = ''
  orig = num
  
  if num >= 1000
    said += ones[(num/1000).floor] + " thousand"
    num -= 1000 * (num/1000).floor
  end
  
  if num >= 100
    said += ' ' if orig > 1000
    said += ones[(num/100).floor] + " hundred"
    num -= 100 * (num/100).floor
  end
  
  if num >= 20
    said += ' and ' if orig > 100
    said += tens[(num/10).floor]
    num -= 10 * (num/10).floor
  end
  
  if num >= 10
    said += ' and ' if orig > 100
    said += tentotwenties[num-10]
    num = 0
  end
  
  if num > 0
    said += ' and' if said[-7, 7] == 'hundred'
    said += ' ' if orig > 20
    said += ones[num]
  end
  
  said
end

def count_letters(words)
  words.split.inject(0) {|sum,n|
    sum + n.length
  }
end

if __FILE__ == $0
  sum = 0
  (1..1000).each {|n|
    said = say_number n
    puts said
    sum += count_letters(said)
  }
  
  puts sum
end