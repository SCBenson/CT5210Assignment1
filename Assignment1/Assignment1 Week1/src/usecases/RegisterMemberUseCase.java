package usecases;

import entities.Member;

public class RegisterMemberUseCase {
    private final LibraryRepository repo;

    public RegisterMemberUseCase(LibraryRepository repo) {
        this.repo = repo;
    }

    public void execute(Member member) {
        repo.addMember(member);
    }
}
