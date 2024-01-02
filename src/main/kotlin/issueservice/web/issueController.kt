package issueservice.web

import issueservice.config.AuthUser
import issueservice.model.IssueRequest
import issueservice.service.IssueService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/issues")
class IssueController(
  private val issueService: IssueService,
) {
  @PostMapping
  fun createIssue(
    authUser: AuthUser,
    @RequestBody issue: IssueRequest,
  ) = issueService.createIssue(authUser.userId, issue)
}
