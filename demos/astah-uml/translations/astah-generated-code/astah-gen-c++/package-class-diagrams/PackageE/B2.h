#ifndef PACKAGE-CLASS-DIAGRAMS_PACKAGEE_B2_H
#define PACKAGE-CLASS-DIAGRAMS_PACKAGEE_B2_H

#include <string>
#include <vector>
#include <list>
#include <iostream>
#include <assert.h>

#include "package-class-diagrams/PackageE/P.h"
#include "package-class-diagrams/PackageE/A1.h"
#include "package-class-diagrams/PackageE/A2.h"

namespace package-class-diagrams
{
    
// C++    
namespace PackageE
{
    class B2 : public P, public A1, public A2
    {
    };
}  // namespace PackageE
    
    
}  // namespace package-class-diagrams
#endif
