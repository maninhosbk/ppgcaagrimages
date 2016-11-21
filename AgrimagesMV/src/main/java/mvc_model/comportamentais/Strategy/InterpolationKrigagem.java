package mvc_model.comportamentais.Strategy;

public class InterpolationKrigagem implements StrategyInterpolation{

	@Override
	public String doInterpolation(String dado1, String dado2) {
		// TODO Auto-generated method stub
		return "Interpolação por Krigagem entre "+dado1+" e "+dado2+" 2";
	}
}
