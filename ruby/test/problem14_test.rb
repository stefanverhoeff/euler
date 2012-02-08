require 'test/unit'
require 'benchmark'
require 'problem14.rb'

class TC_Problem14Test < Test::Unit::TestCase
  # def setup
  # end
  
  # def teardown
  # end
  
  def test_next_n
    assert_equal(40, next_n(13))
    assert_equal(20, next_n(40))
    assert_equal(10, next_n(20))
    assert_equal(5, next_n(10))
    assert_equal(16, next_n(5))
    assert_equal(8, next_n(16))
    assert_equal(4, next_n(8))
    assert_equal(2, next_n(4))
    assert_equal(1, next_n(2))
  end
  
  def test_chain
#    assert_equal([13, 40, 20, 10, 5, 16, 8, 4, 2, 1], chain(13))
    assert_equal(10, chain(13))
  end
  
  def test_solution
#    puts Benchmark.measure { puts find_largest_chain_until(100_000)}
    puts Benchmark.measure { find_largest_chain_until(1_000_000)}
    puts "Loops #{$loops}"
    puts "LUT size #{$lut.size}"
  end
end