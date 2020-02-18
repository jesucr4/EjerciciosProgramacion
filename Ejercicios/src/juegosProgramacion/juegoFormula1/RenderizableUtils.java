package juegoFormula1;

import java.awt.BasicStroke;

public class RenderizableUtils {

	final static BasicStroke SIMPLE = new BasicStroke(1.0f);
	final static BasicStroke STROKE = new BasicStroke(2.0f);
    final static BasicStroke WIDE_STROKE = new BasicStroke(8.0f);
    final static float DASH1[] = {10.0f};
    final static BasicStroke DASHED = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, DASH1, 0.0f);
    final static BasicStroke DOTTED = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] {1,2}, 0);
}
