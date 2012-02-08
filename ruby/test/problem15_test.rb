require 'test/unit'
require 'benchmark'
require 'problem15.rb'

class TC_Problem15Test < Test::Unit::TestCase
  # def setup
  # end
  
  # def teardown
  # end
  
  def test_routes_in_grid
    assert_equal(2, routes_in_grid(1))
    assert_equal(6, routes_in_grid(2))
    assert_equal(20, routes_in_grid(3))
  end
  
  def test_cuby
    assert_equal(2, gen_cuby(1))
    assert_equal(6, gen_cuby(2))
    assert_equal(20, gen_cuby(3))
  end
  
  def test_calc_routes
    grid = gen_grid(2)
    routes = calc_routes(grid, 2+2)
    assert_equal(6, routes)
  end
  
  def test_gen_grid
    x0y0 = Node.new('x0y0')
    x1y0 = Node.new('x1y0')
    x0y1 = Node.new('x0y1')
    x1y1 = Node.new('x1y1')
    x0y0.right = x0y1
    x0y0.down = x1y0
    x1y0.right = x1y1
    x0y1.down = x1y1
    
    sample = [[x0y0, x0y1],
              [x1y0, x1y1]]
    
    p sample
    p gen_grid(1)
    
    assert_equal(sample, gen_grid(1))
  end
  
  def test_solution
#    puts Benchmark.measure { puts routes_in_grid(20)}
  end
end