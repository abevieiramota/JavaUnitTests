package abevieiramota.learning.junit.passo1testsuit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	
	TestClass1.class, 
	TestClass2.class,
	InternalTestSuit.class
	
})
// por que utilizar?
// pode-se utilizar com diversos níveis.
public class TestSuit {

}
