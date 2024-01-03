package issueservice.domain

import org.springframework.data.jpa.repository.JpaRepository

interface IssueRepository: JpaRepository<Issue, Long> {
  fun findAllByUserIdAndStatusOrderByCreatedAtDesc(userId: Long, status: IssueStatus): List<Issue>?
}
