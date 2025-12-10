import { createRouter, createWebHistory } from 'vue-router'
import MainApp from '@/components/MainApp.vue'
import AdminApp from '@/components/AdminApp.vue'
import ContestApp from '@/components/ContestApp.vue'
import TeamApp from '@/components/TeamApp.vue'
import ScheduleApp from '@/components/ScheduleApp.vue'
import ResultApp from '@/components/ResultApp.vue'
import LogApp from '@/components/LogApp.vue'
import ProfileApp from '@/components/ProfileApp.vue'

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
            path: 'contest',
            name: 'Contests',
            component: ContestApp
        },
        {
            path: 'team',
            name: 'Teams',
            component: TeamApp
        },
        {
            path: 'schedule',
            name: 'Schedule',
            component: ScheduleApp
        },
        {
            path: 'result',
            name: 'Results',
            component: ResultApp
        },
        {
            path: 'log',
            name: 'Logs',
            component: LogApp
        },
        {
            path: 'profile',
            name: 'Profiles',
            component: ProfileApp
        }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL), 
  routes
})

export default router