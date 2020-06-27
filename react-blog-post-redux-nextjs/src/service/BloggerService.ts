declare type BloggerEntry = {
  id: {
    $t: string
  },
  updated: {
    $t: string
  },
  published: {
    $t: string
  },
  category: Array<{scheme: string, term: string}>,
  title: {
    $t: string
  },
  summary: {
    $t: string
  },
  author: Array<{name: { $t: string }}>,
  link: Array<{ rel: string, href: string }>
}

const getAllPosts = async() => {
  const response = await fetch('https://www.blogger.com/feeds/5554118637855932326/posts/summary?alt=json&start-index=1&max-results=100')
  const result = await response.json();
  const categories = result?.feed?.category ?? [];
  const allTags = (categories as Array<{term: string}>).map(category => category.term)
  const entries = result?.feed?.entry ?? [];
  const posts = (entries as Array<BloggerEntry>).map(entry => {
    const id = entry.id.$t;
    const datePublishedOrUpdated = entry.updated.$t || entry.published.$t;
    const tags = entry.category.map(cat => cat.term);
    const title = entry.title.$t;
    const content = entry.summary.$t;
    const author = entry.author.map(a => a.name.$t).join(', ')
    const postLink = entry.link.find(l => l.rel === 'alternate');
    const postUrl = !!postLink ? postLink.href : '';

    return {
      id,
      tags,
      title,
      content,
      author,
      postUrl,
      postedOn: datePublishedOrUpdated
    }
  })
  return { allTags, posts };
}

export default { getAllPosts }