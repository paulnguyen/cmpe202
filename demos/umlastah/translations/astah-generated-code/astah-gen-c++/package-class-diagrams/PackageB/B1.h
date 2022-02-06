#ifndef PACKAGE-CLASS-DIAGRAMS_PACKAGEB_B1_H
#define PACKAGE-CLASS-DIAGRAMS_PACKAGEB_B1_H

#include <string>
#include <vector>
#include <list>
#include <iostream>
#include <assert.h>

#include "package-class-diagrams/PackageA/A1.h"

namespace package-class-diagrams
{
namespace PackageB
{
class B1 : public package-class-diagrams::PackageA::A1
{
public:
	void accessPublicA1();
	void accessProtectedA1();
	void accessPackageA1();
	void accessPrivateA1();
};

}  // namespace PackageB
}  // namespace package-class-diagrams
#endif
