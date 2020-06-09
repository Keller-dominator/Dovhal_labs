package ua.kpi.io93.dovhal.lab5;


public class Lab5 {

	/**
	 * Method that removes from the specified string specified substring.
	 * 
	 * @param t
	 *            associated with an object of class Text.
	 * @param a
	 *            indicates the beginning of the substring.
	 * @param b
	 *            indicates the end of the substring.
	 */
	public static void removeOfString(Text t, Letter a, Letter b) {
		boolean k = true;
		StringBuffer s = new StringBuffer();
		for (int i = 0; i < t.getSentence().length; i++) {
			int a1 = t.getSentence()[i].getSent().indexOf(a.getLetter());
			int b1 = t.getSentence()[i].getSent().lastIndexOf(b.getLetter());
			if (a1 != -1 && b1 != -1) {
				s.append(t.getSentence()[i].getSent().substring(0, a1)
						+ t.getSentence()[i].getSent().substring(b1 + 1));
				k = false;
			} else {
				s.append(t.getSentence()[i].getSent());
			}
		}
		if (k) {
			System.out.println("В данной строке не найдено заданых символов.");
		} else {
			Text t1 = new Text(s.toString());
			System.out.println("Вы ввели текст:\n" + t.getTxt());
			System.out.println("Отредактированный текст:");
			System.out.println(t1.getTxt());
		}
	}

	public static void main(String[] args) {
		String s = "Когда-то несколько мальчиков пошли на черешню без разрешения хозяев этого дерева. Оказалось, что черешень уже нет.";
		Text b = new Text(s);
		Letter a = new Letter('�');
		Letter k = new Letter('�');
		removeOfString(b, a, k);
		Sentence w1 = new Sentence("Roma poshel spat, potomu chto", '.');
		System.out.println(w1.collectSentence());
		System.out.println(b.collectText());
	}
}
