import defaultSettings from '@/settings'

const title = defaultSettings.title || '天机用户管理系统'

export default function getPageTitle(pageTitle) {
  if (pageTitle) {
    return `${pageTitle} - ${title}`
  }
  return `${title}`
}
