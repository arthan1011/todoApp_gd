package org.arthan.todo.build

/**
 * Created by arthan on 24.11.2016. | Project todoApp_gd
 */
class ProjectVersion {
    Integer major;
    Integer minor;
    boolean release;

    ProjectVersion(Integer major, Integer minor) {
        this(major, minor, Boolean.FALSE)
    }

    ProjectVersion(Integer major, Integer minor, boolean release) {
        this.major = major
        this.minor = minor
        this.release = release
    }

    @Override
    public String toString() {
        return "$major.$minor${release ? '' : '-SNAPSHOT'}";
    }
}
