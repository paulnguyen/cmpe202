#ifndef PACKAGE-CLASS-DIAGRAMS_PACKAGEF_MARRIAGE4_H
#define PACKAGE-CLASS-DIAGRAMS_PACKAGEF_MARRIAGE4_H

#include <string>
#include <vector>
#include <list>
#include <iostream>
#include <assert.h>

#include "java/lang/String.h"
#include "java/util/Date.h"
#include "package-class-diagrams/PackageF/Woman3.h"
#include "package-class-diagrams/PackageF/Man3.h"

namespace package-class-diagrams
{
namespace PackageF
{
class Marriage4
{
private:
	java::util::Date date;
	java::lang::String place;
	boolean divorced;
	int number;
	Woman3 husbands[];
	Man3 wifes[];
};

}  // namespace PackageF
}  // namespace package-class-diagrams
#endif
