#ifndef PACKAGE-CLASS-DIAGRAMS_PACKAGEA_A1_H
#define PACKAGE-CLASS-DIAGRAMS_PACKAGEA_A1_H

#include <string>
#include <vector>
#include <list>
#include <iostream>
#include <assert.h>

namespace package-class-diagrams
{
namespace PackageA
{
class A1
{
private:
	int privateA1;
 
protected:
	int protectedA1;
	int packageA1;
 
public:
	int publicA1;
 
public:
	void accessPublicA1();
	void accessProtectedA1();
	void accessPackageA1();
	void accessPrivateA1();
};

}  // namespace PackageA
}  // namespace package-class-diagrams
#endif
