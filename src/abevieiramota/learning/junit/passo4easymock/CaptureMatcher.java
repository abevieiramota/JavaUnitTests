package abevieiramota.learning.junit.passo4easymock;

import static org.easymock.EasyMock.captureInt;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.reset;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.easymock.Capture;
import org.easymock.CaptureType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * 
 * @author abelardo.mota
 *
 */
// UTILIDADE?
@RunWith(JUnit4.class)
public class CaptureMatcher extends Basico {

	@Test
	public void capturaDeParametroMockado() {
		Capture<Integer> cap = new Capture<Integer>(CaptureType.ALL);
		
		expect(calc.soma(eq(2), captureInt(cap))).andReturn(33);
		
		replay(calc);
		
		assertThat(calc.soma(2, 22), is(equalTo(33)));
		
		reset(calc);
		
		expect(calc.soma(cap.getValue(), cap.getValue())).andReturn(10);
		
		replay(calc);
		
		assertThat(calc.soma(22, 22), is(equalTo(10)));
	}
}
