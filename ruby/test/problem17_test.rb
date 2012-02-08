require 'test/unit'
require 'benchmark'
require 'problem17.rb'

class TC_Problem17Test < Test::Unit::TestCase
  # def setup
  # end
  
  # def teardown
  # end
  
  def test_say_number
    assert_equal("four", say_number(4))
    assert_equal("eight", say_number(8))
    assert_equal("thirteen", say_number(13))
    assert_equal("sixty", say_number(60))
    assert_equal("seventy", say_number(70))
    assert_equal("forty two", say_number(42))
    assert_equal("ninety three", say_number(93))
    assert_equal("three hundred and forty two", say_number(342 ))
    assert_equal("one hundred and seven", say_number(107))
    assert_equal("one hundred and fifteen", say_number(115))
    assert_equal("one thousand two hundred and thirty four", say_number(1234))
  end
  
  def test_count_letters
    assert_equal(23, count_letters("three hundred and forty two"))
    assert_equal(20, count_letters("one hundred and fifteen"))
  end
end