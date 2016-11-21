package mvc_model.comportamentais.Strategy;

public class Context {
	private StrategyInterpolation strategy;

	public Context(StrategyInterpolation strategy){
		this.strategy = strategy;
	}

	public String executeStrategy(String dado1, String dado2){
		return strategy.doInterpolation(dado1, dado2);
	}
}
