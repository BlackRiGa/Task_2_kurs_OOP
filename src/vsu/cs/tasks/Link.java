package vsu.cs.tasks;

public class Link {
    public final String What;
    public final String WithWhom;
    public final LinkType LinkType;

    public Link(String what, String withWhom, LinkType linkType) {
        What = what;
        WithWhom = withWhom;
        LinkType = linkType;
    }
}
