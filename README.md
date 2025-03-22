# Job Application Management System

| Entity 1  | Relationship Type | Entity 2  | Description |
|-----------|-------------------|-----------|-------------|
| **User** → **Job**  | One-to-Many  | **Job** | A recruiter (`User`) can post multiple jobs. Each `Job` is associated with one recruiter. |
| **User** → **Application**  | One-to-Many  | **Application** | A job seeker (`User`) can apply to multiple jobs. Each `Application` is linked to one user. |
| **Job** → **Application**  | One-to-Many  | **Application** | A job can have multiple applications from different job seekers. Each `Application` is linked to one job. |

### Entity Roles:
- **User**: Can be a **job seeker**, **recruiter**, or **admin**.
    - **Job Seekers** can apply for jobs (One-to-Many with `Application`).
    - **Recruiters** can post jobs (One-to-Many with `Job`).
- **Job**: Represents a job posting, created by a recruiter (`User`).
- **Application**: Represents a job application, linking a job seeker (`User`) with a `Job`.

Each relationship is managed using JPA annotations such as `@OneToMany` and `@ManyToOne`.
