package VocabQuiz;

public class QuizSenderVo {
	private String Reading1;
	private String Reading2;
	private String Reading3;

	public QuizSenderVo() {

	}

	public QuizSenderVo(String Reading1, String Reading2, String Reading3) {
		this.Reading1 = Reading1;
		this.Reading2 = Reading2;
		this.Reading3 = Reading3;
	}

	public String getReading1() {
		return Reading1;
	}

	public String getReading2() {
		return Reading2;
	}

	public String getReading3() {
		return Reading3;
	}

}