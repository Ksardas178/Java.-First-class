package MyPackage;

public enum Element {
    X,
    Y,
    EMPTY;

    public static int longest(){
        int result = 0;
        for (Element el : Element.values()){
            int l = el.toString().length();
            if (l>result) result = l;
        }
        return result;
    }
}
