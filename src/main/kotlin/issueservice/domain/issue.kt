package issueservice.domain

import jakarta.persistence.*

@Entity
@Table
class Issue(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long? = null,
  var userId: Long,
  var summary: String,
  var description: String,
  @Enumerated(EnumType.STRING)
  var type: IssueType,
  @Enumerated(EnumType.STRING)
  var priority: IssuePriority,
  @Enumerated(EnumType.STRING)
  var status: IssueStatus,
): BaseEntity()
