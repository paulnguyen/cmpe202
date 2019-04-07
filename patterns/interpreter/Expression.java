
package interpreter ;

import java.util.Map;

interface Expression {
    public int interpret(final Map<String, Expression> variables);
}