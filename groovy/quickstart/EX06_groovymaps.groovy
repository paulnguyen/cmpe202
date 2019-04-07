
def map = [ 'name' : 'James', 'location' : 'London' ]
println map.size() == 2
println map.get('name') == 'James'
println map['name'] == 'James'


def map = [ 'name':'James', 'location':'London' , 'a' : ['b':'value'] ]
println map.size() 
println map['location']
map['job'] = 'Coder'
println map.size() 
println map