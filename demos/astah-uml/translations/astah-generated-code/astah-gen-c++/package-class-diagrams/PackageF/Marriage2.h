#ifndef PACKAGE-CLASS-DIAGRAMS_PACKAGEF_MARRIAGE2_H
#define PACKAGE-CLASS-DIAGRAMS_PACKAGEF_MARRIAGE2_H

#include <string>
#include <vector>
#include <list>
#include <iostream>
#include <assert.h>

#include "java/lang/String.h"
#include "java/util/Date.h"
#include "package-class-diagrams/PackageF/Person.h"

namespace package-class-diagrams
{
namespace PackageF
{
class Marriage2
{
private:
	java::util::Date date;
	java::lang::String place;
	Person wife;
	Person husband;
};

}  // namespace PackageF
}  // namespace package-class-diagrams
#endif
