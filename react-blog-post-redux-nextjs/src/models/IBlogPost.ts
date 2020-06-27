interface IBlogPost {
  id: string
  title: string
  content: string
  author: string
  postedOn: string
  tags: string[]
  postUrl: string
}

export default IBlogPost;