#ifndef PACKAGE-CLASS-DIAGRAMS_PACKAGEF_MARRIAGE1_H
#define PACKAGE-CLASS-DIAGRAMS_PACKAGEF_MARRIAGE1_H

#include <string>
#include <vector>
#include <list>
#include <iostream>
#include <assert.h>

#include "java/lang/String.h"
#include "java/util/Date.h"
#include "package-class-diagrams/PackageF/Woman1.h"
#include "package-class-diagrams/PackageF/Man1.h"

namespace package-class-diagrams
{
namespace PackageF
{
class Marriage1
{
private:
	java::util::Date date;
	java::lang::String place;
	Woman1 wife;
	Man1 husband;
};

}  // namespace PackageF
}  // namespace package-class-diagrams
#endif
