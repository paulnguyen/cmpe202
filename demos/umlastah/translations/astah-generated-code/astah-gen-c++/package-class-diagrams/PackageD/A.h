#ifndef PACKAGE-CLASS-DIAGRAMS_PACKAGED_A_H
#define PACKAGE-CLASS-DIAGRAMS_PACKAGED_A_H

#include <string>
#include <vector>
#include <list>
#include <iostream>
#include <assert.h>

#include "package-class-diagrams/PackageD/P.h"
#include "package-class-diagrams/PackageD/C1.h"
#include "package-class-diagrams/PackageD/D1.h"
#include "package-class-diagrams/PackageD/E1.h"
#include "package-class-diagrams/PackageD/D2.h"
#include "package-class-diagrams/PackageD/E2.h"
#include "package-class-diagrams/PackageD/C2.h"
#include "package-class-diagrams/PackageD/C3.h"
#include "package-class-diagrams/PackageD/C4.h"
#include "package-class-diagrams/PackageD/E3.h"
#include "package-class-diagrams/PackageD/E4.h"
#include "package-class-diagrams/PackageD/D3.h"
#include "package-class-diagrams/PackageD/D4.h"
#include "package-class-diagrams/PackageD/G.h"
#include "package-class-diagrams/PackageD/H1.h"
#include "package-class-diagrams/PackageD/H2.h"
#include "package-class-diagrams/PackageD/F.h"

namespace package-class-diagrams
{
namespace PackageD
{
class A : public P
{
private:
	C1 c1;
	D1 d1;
	E1 e1;
	D2 d2;
	E2 e2;
	C2 c2;
	C3 c3;
	C4 c4;
	E3 e3[];
	E4 items[];
	D3 d3[];
	D4 members[];
	G g;
	H1 h[];
	H2 h2[];
 
public:
	void operationA1(F arg);
};

}  // namespace PackageD
}  // namespace package-class-diagrams
#endif
