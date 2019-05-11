
#
#	Ruby Programming Language 
#
#	https://www.ruby-lang.org
#
#

##
## Just Enough Ruby from
## Book:  Understanding Computation
##
## https://computationbook.com/
## https://github.com/tomstuart/computationbook


## Objects and Methods
## -------------------

## Ruby looks like other dynamic programming languages but it’s unusual in an
## important way: every value is an object, and objects communicate by sending
## messages to each other.[1] Each object has its own collection of methods
## that determine how it responds to particular messages.

o = Object.new

def o.add(x, y)
     x + y
end

o.add(2, 3)


def o.add_twice(x, y)
     add(x, y) + add(x, y)
end

o.add_twice(2, 3)

## Outside of any method definition, the current object is a special top-level
## object called main, and any messages that don’t specify a receiver are sent
## to it; similarly, any method definitions that don’t specify an object will
## be made available through main

def multiply(a, b)
     a * b
end

multiply(2, 3)



## Classes and Inheritance
## -----------------------

## It’s convenient to be able to share method definitions between many
## objects. In Ruby, we can put method definitions inside a class, then create
## new objects by sending the new message to that class. The objects we get
## back are instances of the class and incorporate its methods. For example:

class Calculator
 def divide(x, y)
   x / y
 end
end

c = Calculator.new
c.class
c.divide(10, 2)

## Note that defining a method inside a class definition adds the method to
## instances of that class, not to main:

divide(10, 2) ## NoMethodError: undefined method `divide' for main:Object

## One class can bring in another class’s method definitions through inheritance:

class MultiplyingCalculator < Calculator
 def multiply(x, y)
   x * y
 end
end

mc = MultiplyingCalculator.new
mc.class
mc.class.superclass
mc.multiply(10, 2)
mc.divide(10, 2)

## A method in a subclass can call a superclass method of the same name by
## using the super keyword:

class BinaryMultiplyingCalculator < MultiplyingCalculator
  def multiply(x, y)
    result = super(x, y)
    result.to_s(2)
  end
end

bmc = BinaryMultiplyingCalculator.new
bmc.multiply(10, 2)


## Classes and Modules
## -------------------

## Another way of sharing method definitions is to declare them in a module,
## which can then be included by any class:

module Addition
  def add(x, y)
    x + y
  end
end

class AddingCalculator
  include Addition
end

ac = AddingCalculator.new
ac.add(10, 2)


#
# Ruby OOP Tutorial
#
# REF:  http://ruby-doc.com/docs/ProgrammingRuby/html/tut_classes.html

class Song
  def initialize(name, artist, duration)
    @name     = name
    @artist   = artist
    @duration = duration
  end
end

# initialize is a special method in Ruby programs. When you call Song.new to 
# create a new Song object, Ruby creates an uninitialized object and then calls 
# that object's initialize method, passing in any parameters that were passed to new. 
# This gives you a chance to write code that sets up your object's state. 
#
# In Ruby, an instance variable is simply a name preceded by an "at" sign (@). 

aSong = Song.new("Bicylops", "Fleck", 260)
aSong.inspect

# By default, the inspect message, which can be sent to any object, dumps out the 
# object's id and instance variables. It looks as though we have them set up correctly. 

aSong.to_s

# Ruby has a standard message, to_s, which it sends to any object it wants to render as a string

class Song
  def to_s
    "Song: #{@name}--#{@artist} (#{@duration})"
  end
end
aSong.to_s


# The "< Song" on the class definition line tells Ruby that a KaraokeSong is a subclass of Song.
# (Not surprisingly, this means that Song is a superclass of KaraokeSong. People also talk about 
# parent-child relationships, so KaraokeSong's parent would be Song.) For now, don't worry too 
# much about the initialize method; we'll talk about that super call later. 

class KaraokeSong < Song
  def initialize(name, artist, duration, lyrics)
    super(name, artist, duration)
    @lyrics = lyrics
  end
end

aSong = KaraokeSong.new("My Way", "Sinatra", 225, "And now, the...")
aSong.to_s


# We get around this problem by having each class handle its own internal state. 
# When KaraokeSong#to_s is called, we'll have it call its parent's to_s method to 
# get the song details. It will then append to this the lyric information and return 
# the result. The trick here is the Ruby keyword ``super''. When you invoke super with 
# no arguments, Ruby sends a message to the current object's parent, asking it to invoke 
# a method of the same name as the current method, and passing it the parameters that were 
# passed to the current method. Now we can implement our new and improved to_s. 

class KaraokeSong < Song
  # Format ourselves as a string by appending
  # our lyrics to our parent's #to_s value.
  def to_s
    super + " [#{@lyrics}]"
  end
end

aSong = KaraokeSong.new("My Way", "Sinatra", 225, "And now, the...")
aSong.to_s


# Here we've defined three accessor methods to return the values of the 
# three instance attributes. 

class Song
  def name
    @name
  end
  def artist
    @artist
  end
  def duration
    @duration
  end
end
aSong = Song.new("Bicylops", "Fleck", 260)
aSong.artist 
aSong.name  
aSong.duration 

# Because this is such a common idiom, Ruby provides a convenient 
# shortcut: attr_reader creates these accessor methods for you. 

class Song
  attr_reader :name, :artist, :duration
end
aSong = Song.new("Bicylops", "Fleck", 260)
aSong.artist 
aSong.name  
aSong.duration  

#
# Setter Functions In languages such as C++ and Java, you'd do this with... 
#
# class JavaSong {                     
#  private Duration myDuration;
#  public void setDuration(Duration newDuration) {
#    myDuration = newDuration;
#  }
# }
# s = new Song(....)
# s.setDuration(length)
#

# In Ruby, the attributes of an object can be accessed as if they were any other 
# variable. We've seen this above with phrases such as aSong.name. So, it seems 
# natural to be able to assign to these variables when you want to set the value 
# of an attribute. In keeping with the Principle of Least Surprise, that's just 
# what you do in Ruby. 

class Song
  def duration=(newDuration)
    @duration = newDuration
  end
end
aSong = Song.new("Bicylops", "Fleck", 260)
aSong.duration = 257
aSong.inspect

# Again, Ruby provides a shortcut for creating these simple attribute setting methods. 

class Song
  attr_writer :duration
end
aSong = Song.new("Bicylops", "Fleck", 260)
aSong.duration = 257


# Class Variables:  @@

class Song
  @@plays = 0
  def initialize(name, artist, duration)
    @name     = name
    @artist   = artist
    @duration = duration
    @plays    = 0
  end
  def play
    @plays += 1
    @@plays += 1
    "This  song: #@plays plays. Total #@@plays plays."
  end
end

s1 = Song.new("Song1", "Artist1", 234)  
s2 = Song.new("Song2", "Artist2", 345)
s1.play 
s2.play   
s1.play 
s1.play   


# Class Methods

class Example
  # instance method
  def instMeth              
  end
  
  # class method
  def Example.classMeth     
  end
end




