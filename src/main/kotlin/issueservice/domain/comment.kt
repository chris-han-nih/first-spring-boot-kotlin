package issueservice.domain

import jakarta.persistence.*

@Entity
@Table
class Comment(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long? = null,
  var userId: Long,
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "issue_id")
  val issue: Issue,
  var body: String,
): BaseEntity()
