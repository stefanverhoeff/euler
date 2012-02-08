require 'benchmark'
require 'profiler'

class Node
  attr_accessor :right, :down, :name
  
  def initialize(name)
    @name = name
  end
  
  def inspect
    "#{@name}#{@right ? "-R-#{@right.name}" : '       '}#{@down ? "-D-#{@down.name}" : '       '}"
  end
  
  def to_s
    inspect
  end
  
  def ==(lhs)
    return false if lhs == nil
    inspect() == lhs.inspect
  end
end

def routes_in_grid(size)
  grid = gen_grid(size)
  
  # Get all possible routes within steps
  routes = calc_routes(grid, size+size)
  #  puts routes.size
  
  # Remove routes that don't reach destination
  #  destination = grid[size-1][size-1]
  #  routes = routes.select {|route| route[-1] == destination}
  #  puts routes.size
  
  # Number of good routes
  routes
end

def calc_routes(grid, steps)
  nodes = [grid[0][0]]
  
#  p grid
  
  loops1 = 0
  loops2 = 0
  next_nodes = []
  steps.times {
    #    next_nodes = []
    i = 0
    j = 0
    l = nodes.length
    while i < l do 
      #      next_nodes << nodes[i].right if nodes[i].right != nil
      #      next_nodes << nodes[i].down if nodes[i].down != nil
      if nodes[i].right != nil
        next_nodes[j] = nodes[i].right
        j += 1
      end
      if nodes[i].down != nil
        next_nodes[j] = nodes[i].down
        j+=1
      end
      i += 1
      loops1 += 1
    end
    
    nodes = next_nodes[0..j]
#    p next_nodes
#    p nodes
    loops2 += 1
  }
  
  puts "loops #{loops2}"
  puts "inner loops #{loops1}"
  
  nodes.size
end

def gen_cuby(size)
  
  # build the matrix
  cuby = Array.new(size+1).map { Array.new(size+1).map { 0 } }
  cuby[0][0] = 1
  
  # fill out values
  (0..size).each {|i|
    (0..size).each {|j|
      cuby[i][j] += cuby[i-1][j] if i > 0
      cuby[i][j] += cuby[i][j-1] if j > 0
    }
  }

  cuby[size][size]
end

def gen_grid(size)
  grid = []
  
  # create the grid
   (0..size).each {|x|
    grid[x] = []
    
     (0..size).each {|y|
      grid[x][y] = Node.new("x#{x}y#{y}")
    }
  }
  
  # connect the nodes
   (0..size).each {|x|
   (0..size).each {|y|
      grid[x][y].right = grid[x][y+1] if grid[x][y+1] != nil
      grid[x][y].down = grid[x+1][y] if grid[x+1] != nil
    }
  }
  
  grid
end

if __FILE__ == $0
  puts gen_cuby(20)
  
  #  gen_grid(20).each {|line|
  #    p line
  #  }
  #  puts "20 = #{routes_in_grid(20)}"
  
#  Profiler__::start_profile
#   (1..6).each {|n|
#    puts Benchmark.measure { puts "#{n} = #{routes_in_grid(n)}" }
#  }
#  Profiler__::stop_profile
#  Profiler__::print_profile($stderr)
end