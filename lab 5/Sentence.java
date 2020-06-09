package ua.kpi.io93.dovhal.lab5;

import java.util.ArrayList;

public class Sentence {

	private String sent;

	private Word[] words;

	private ArrayList<Punctuation> p;

	public Sentence(String a, char s) {
		setSent(a + s);
		ArrayList<Punctuation> p1 = new ArrayList<Punctuation>();
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == ',' || a.charAt(i) == ';' || a.charAt(i) == ':'
					|| a.charAt(i) == '-') {
				p1.add(new Punctuation(a.charAt(i), i));
			}
		}
		p1.add(new Punctuation(s, a.length()));
		p = p1;
		String sent1[] = a.split("[,-:;]\\s|\\s[,-:;]|[,-:;]|\\s");
		int k = 0;
		for (int i = 0; i < sent1.length; i++) {
			if (sent1[i].isEmpty()) {
				k++;
			}
		}
		this.words = new Word[sent1.length - k];
		for (int i = 0, j = 0; i < sent1.length; i++) {
			if (!sent1[i].isEmpty()) {
				words[j] = new Word(sent1[i]);
				j++;
			}
		}
	}

	/**
	 * @return value of field "sent".
	 */
	public String getSent() {
		return new String(sent);
	}

	/**
	 * @param sent
	 *            is assigned to the field "sent".
	 */
	public void setSent(String sent) {
		this.sent = new String(sent);
	}

	/**
	 * @return field "words".
	 */
	public Word[] getWords() {
		return words.clone();
	}

	/**
	 * @param word
	 *            is assigned to the field "words".
	 */
	public void setWord(Word[] word) {
		this.words = word.clone();
	}

	/**
	 * @return field "p".
	 */
	public ArrayList<Punctuation> getP() {
		return new ArrayList<Punctuation>(p);
	}

	/**
	 * @param p
	 *            is assigned to the field "p";
	 */
	public void setP(ArrayList<Punctuation> p) {
		this.p = new ArrayList<Punctuation>(p);
	}

	public StringBuffer collectSentence() {
		StringBuffer s = new StringBuffer();
		for (int i = 0, j = 0, z = 0; i < this.words.length; i++) {
			z = z + words[i].collectWord().length();
			if (z + 1 == p.get(j).getPosition()
					|| z + 2 == p.get(j).getPosition()) {
				s.append(words[i].collectWord());
				s.append(p.get(j).getSymbol());
				s.append(" ");

				j++;
			} else {
				s.append(words[i].collectWord());
				s.append(" ");
			}
		}
		s.append(p.get(p.size() - 1).getSymbol());
		return s;
	}
}
