public class OffByN implements CharacterComparator{
    private static int diff;
    public OffByN(int N) {
        diff = N;
    }
    @Override
    public boolean equalChars(char x, char y) {
        return x == y + diff || x ==y - diff;
    }

}
