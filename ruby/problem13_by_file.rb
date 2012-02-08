File.open("problem12.txt") do |file|
  sum = 0
  while content = file.gets
  # ... operations on file
    sum += content.to_i
  end

  puts sum
end