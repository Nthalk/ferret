package com.iodesystems.ferret.route;

public class PathSegment {
    private final String segment;

    public PathSegment(String segment) {
        this.segment = segment;
    }

    public static PathSegment convert(String segment) {
        if (segment.startsWith(":")) {
            return new PathVariableSegment(segment);
        } else {
            return new PathSegment(segment);
        }
    }

    public String getSegment() {
        return segment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PathSegment that = (PathSegment) o;

        return segment != null ? segment.equals(that.segment) : that.segment == null;

    }

    @Override
    public int hashCode() {
        return segment != null ? segment.hashCode() : 0;
    }
}
