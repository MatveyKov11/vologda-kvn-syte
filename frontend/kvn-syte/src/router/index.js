import { createRouter, createWebHistory } from 'vue-router'
import MainApp from '@/components/MainApp.vue'
import AdminApp from '@/components/AdminApp.vue'
import LogViewer from '@/components/LogViewer.vue'
import ProfileViewer from '@/components/ProfileViewer.vue'
import EditorApp from '@/components/EditorApp.vue'
import TableViewer from '@/components/TableViewer.vue'
import PostViewer from '@/components/PostViewer.vue'
import StyleViewer from '@/components/StyleViewer.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: MainApp
  },
  {
    path: '/admin',
    name: 'Admin Home',
    component: AdminApp,
    children: [
      {
        path: 'log',
        name: 'Logs',
        component: LogViewer
      },
      {
        path: 'profile',
        name: 'Profiles',
        component: ProfileViewer
      },
      {
        path: 'post',
        name: 'Posts',
        component: PostViewer
      },
      {
        path: 'table',
        name: 'Tables',
        component: TableViewer
      },
      {
        path: 'style',
        name: 'Styles',
        component: StyleViewer
      }
    ]
  },
  {
    path: '/editor',
    name: 'Editor Home',
    component: EditorApp,
    children: [
    ]
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL), 
  routes
})

export default router