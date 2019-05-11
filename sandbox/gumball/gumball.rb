
module CrankModel
  def insertQuarter
    insert( 25 )
  end

  def turnTheCrank
    eject()
  end
end

module SlotModel
  def insertCoin( value )
    @coinValue = @coinValue + value 
    if @coinValue >= @cost
      eject()
    end
  end

  def returnCoins
    puts "Change Return: #{@coinValue}  cents." 
  end
end


class GumballMachine

  def initialize(c)
 	@model = "M1V192019"
 	@serial = "123997919189" 
 	@coinValue = 0 	
    @cost = c
    @count = 100
  end

  def configCost( theCost )
  	cost = theCost
  end

  def insert( value )
    newValue = @coinValue + value
  	puts "#{newValue} > ${@cost}?"
  	if newValue > @cost
  		puts "There's already enough money!"
  	else
  		@coinValue = newValue 
  	end
  end

  def eject()
  	if @coinValue < @cost 
  		puts "Not Enough Money!"
  	elsif @count > 0
  		@count = @count - 1
  		puts "Gumball Ejected!"
  		puts "Change Return:  #{@coinValue - @cost} cents."
  		@coinValue = 0 
  	else
  		puts "Sorry! Out of Gumballs."
  	end
  end

  def debug
    puts "#{@model} #{@serial} val:#{@coinValue} cost:#{@cost} cnt:#{@count}"
  end

  include CrankModel
  include SlotModel

end


m = GumballMachine.new(50)
m.configCost(50)
m.debug()

## Crank Test
m.insertQuarter()
m.insertQuarter()
m.turnTheCrank()


## Slot Test 
m.insertCoin(25)
m.insertCoin(100)	

