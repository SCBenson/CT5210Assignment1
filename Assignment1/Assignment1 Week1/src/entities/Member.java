package entities;

public class Member {
    private final String name;
    private final String memberId;

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Member{name='" + name + "', memberId='" + memberId + "'}";
    }
}
