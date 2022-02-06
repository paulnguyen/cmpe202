#ifndef PACKAGE-CLASS-DIAGRAMS_PACKAGEC_A_H
#define PACKAGE-CLASS-DIAGRAMS_PACKAGEC_A_H

#include <string>
#include <vector>
#include <list>
#include <iostream>
#include <assert.h>

#include "package-class-diagrams/PackageC/B.h"
#include "package-class-diagrams/PackageC/C.h"
#include "package-class-diagrams/PackageC/D.h"

namespace package-class-diagrams
{
    
// C++
namespace PackageC
{
    class A
    {
    private:
        int x;
        int y[];
        B b[];
        C c;
        D d[];
    };
}  // namespace PackageC
    
    
}  // namespace package-class-diagrams
#endif
