package exercise;

// BEGIN
public class ReversedSequence implements CharSequence{
    CharSequence text;
    public ReversedSequence(CharSequence text) {
        this.text = text;
    }

    @Override
    public int length() {
        return text.length();
    }

    @Override
    public char charAt(int i) {
        return text.charAt(text.length() - i - 1);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        StringBuilder revertedSubSequence = new StringBuilder();
        for (var n = i; n < i1; n++ ) {
            revertedSubSequence.append(this.text.charAt(text.length() - n - 1));
        }
        return revertedSubSequence.toString();
    }

    public String toString() {
        StringBuilder reverted = new StringBuilder();
        for (var i = 0; i < text.length(); i++) {
            reverted.append(this.text.charAt(text.length() - i - 1));
        }
        return reverted.toString();
    }
}
// END
