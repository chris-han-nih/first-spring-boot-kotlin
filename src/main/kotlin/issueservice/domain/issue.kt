package issueservice.domain

import jakarta.persistence.*

@Entity
@Table
class Issue(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long? = null,
  var userId: Long,
  var summary: String,
  var description: String,
  @OneToMany(fetch = FetchType.EAGER)
  var comments: List<Comment> = listOf(),
  @Enumerated(EnumType.STRING)
  var type: IssueType,
  @Enumerated(EnumType.STRING)
  var priority: IssuePriority,
  @Enumerated(EnumType.STRING)
  var status: IssueStatus,
): BaseEntity()
