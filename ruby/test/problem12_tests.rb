require 'test/unit'
require 'problem12.rb'

class TC_MyPrimeTest < Test::Unit::TestCase
  # def setup
  # end
  
  # def teardown
  # end
  
  def test_prime?
    assert_equal(true, prime?(3))
    assert_equal(true, prime?(5))
    assert_equal(false, prime?(21))
    assert_equal(true, prime?(23))
    assert_equal(true, prime?(6221))
    assert_equal(false, prime?(4531))
  end
  
  def test_prime2?
    assert_equal(true, prime2?(3))
    assert_equal(true, prime2?(5))
    assert_equal(false, prime2?(21))
    assert_equal(true, prime2?(23))
    assert_equal(true, prime2?(6221))
    assert_equal(false, prime2?(4531))
  end
  
  def test_smallest_prime_divisor
    assert_equal(3, smallest_prime_divisor(21))
    assert_equal(2, smallest_prime_divisor(28))
    assert_equal(29, smallest_prime_divisor(29))
  end
  
  def test_num_divisors_by_prime
    any_test_num_divisors(:num_divisors_by_prime)
  end
  
  def test_num_divisors
    any_test_num_divisors(:num_divisors)
    
    puts "num divs for 2000 = #{num_divisors 2000}"
    puts "num divs for 1337 = #{num_divisors 1337}"
  end
  
  def test_num_divisors_sqrt
    any_test_num_divisors(:num_divisors_sqrt)
  end
  
  def test_num_divisors_by_all_primes
    any_test_num_divisors(:num_divisors_by_all_primes)
  end

  def any_test_num_divisors(func_num_divisors)
    assert_equal(1, send(func_num_divisors, 1))
    assert_equal(2, send(func_num_divisors, 3))
    assert_equal(4, send(func_num_divisors, 6))
    assert_equal(4, send(func_num_divisors, 10))
    assert_equal(4, send(func_num_divisors, 15))
    assert_equal(4, send(func_num_divisors, 21))
    assert_equal(6, send(func_num_divisors, 28))
    assert_equal(6, send(func_num_divisors, 124))
    assert_equal(20, send(func_num_divisors, 2000))
    assert_equal(4, send(func_num_divisors, 1337))
#    send(func_num_divisors, 264)
#    send(func_num_divisors, 463)
#    send(func_num_divisors, 544)
#    send(func_num_divisors, 651)
#    send(func_num_divisors, 784)
#    send(func_num_divisors, 904)
#    assert_equal(6, send(func_num_divisors, 643))
#    assert_equal(6, send(func_num_divisors, 3228))
#    assert_equal(2, send(func_num_divisors, 7193))
  end
  
#  def test_all_combinations
#    assert_equal([2, 3, 5], all_combinations([2, 3]))
#    assert_equal([3, 7, 21], all_combinations([3, 7]))
#    assert_equal([2, 4, 5, 10, 20], all_combinations([2, 2, 5]))
#    assert_equal([2, 4, 7, 8, 14, 28, 56], all_combinations([2, 2, 2, 7]))
#  end
  
  def test_powerset
    assert_equal([[]], powerset([]).sort.uniq)
    assert_equal([[], [5]], powerset([5]).sort.uniq)
    assert_equal([[], [3], [6], [3,6]].sort, powerset([3,6]).sort.uniq)
    assert_equal([[], [2], [2,2], [5], [2,5], [2,2,5]].sort, powerset([2,2,5]).sort.uniq)
    assert_equal([[], ['a'], ['b'], ['c'], ['a','b'], ['a','c'], ['b','c'], ['a','b','c']].sort, powerset(['a','b','c']).sort.uniq)
    assert_equal([[], ['a'], ['b'], ['c'], ['d'], ['a','b'], ['a','c'], ['a', 'd'], ['b','c'], ['b', 'd'], ['c', 'd'], ['a','b','c'], ['a', 'b', 'd'], ['a', 'c', 'd'], ['b', 'c', 'd'], ['a', 'b', 'c', 'd']].sort, powerset(['a','b','c', 'd']).sort.uniq)
  end
  
#  def test_powerset_sequential
#    assert_equal([[]], powerset_sequential([]).sort.uniq)
#    assert_equal([[], [5]], powerset_sequential([5]).sort.uniq)
#    assert_equal([[], [3], [6], [3,6]].sort, powerset_sequential([3,6]).sort.uniq)
#    assert_equal([[], [2], [2,2], [5], [2,5], [2,2,5]].sort, powerset_sequential([2,2,5]).sort.uniq)
#    assert_equal([[], ['a'], ['b'], ['c'], ['a','b'], ['a','c'], ['b','c'], ['a','b','c']].sort, powerset_sequential(['a','b','c']).sort.uniq)
#    assert_equal([[], ['a'], ['b'], ['c'], ['d'], ['a','b'], ['a','c'], ['a', 'd'], ['b','c'], ['b', 'd'], ['c', 'd'], ['a','b','c'], ['a', 'b', 'd'], ['a', 'c', 'd'], ['b', 'c', 'd'], ['a', 'b', 'c', 'd']].sort, powerset_sequential(['a','b','c', 'd']).sort.uniq)
#  end
  
  def test_get_primes_upto
    assert_equal([2], get_primes_upto(2))
#    assert_equal([2,3,5,7], get_primes_upto(10))
    assert_equal([2,3,5,7,11,13,17,19,23], get_primes_upto(25))
  end
  
  def test_all_prime_divisors
    assert_equal([2,5], all_prime_divisors(10))
    assert_equal([3,7], all_prime_divisors(21))
  end
end
