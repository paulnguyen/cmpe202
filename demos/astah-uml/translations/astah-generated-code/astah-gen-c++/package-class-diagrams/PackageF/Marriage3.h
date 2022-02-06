#ifndef PACKAGE-CLASS-DIAGRAMS_PACKAGEF_MARRIAGE3_H
#define PACKAGE-CLASS-DIAGRAMS_PACKAGEF_MARRIAGE3_H

#include <string>
#include <vector>
#include <list>
#include <iostream>
#include <assert.h>

#include "java/lang/String.h"
#include "java/util/Date.h"
#include "package-class-diagrams/PackageF/Woman2.h"
#include "package-class-diagrams/PackageF/Man2.h"

namespace package-class-diagrams
{
namespace PackageF
{
class Marriage3
{
private:
	java::util::Date date;
	java::lang::String place;
	int number;
	boolean divorced;
	Woman2 wifes[];
	Man2 husband;
};

}  // namespace PackageF
}  // namespace package-class-diagrams
#endif
