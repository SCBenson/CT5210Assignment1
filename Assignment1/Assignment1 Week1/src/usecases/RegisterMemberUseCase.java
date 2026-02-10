package usecases;

import entities.Member;

public class RegisterMemberUseCase {
    private final LibraryRepository repo;

    public RegisterMemberUseCase(LibraryRepository repo) {
        this.repo = repo;
    }

    public void execute(String memberId, String name) {
        Member member = new Member(memberId, name);
        repo.addMember(member);
    }
}