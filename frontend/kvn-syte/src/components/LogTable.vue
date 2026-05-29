<template>
    <div class="ui container">
        <h2 class="ui header">
            <div class="content">
                Логи
            </div>
        </h2>
        <table class="ui table">
        <thead>
            <tr>
                <th class="center aligned">Субъект</th>
                <th class="center aligned">Действие</th>
                <th class="center aligned">Объект</th>
                <th class="center aligned">Время</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="log in logs" :key="log.pos">
                <td>
                    asd
                </td>
                <td>
                    asd
                </td>
                <td>
                    asd
                </td>
                <td>
                    asd
                </td>
            </tr>
        </tbody>
    </table>
    </div>
</template>

<script setup>
import { ref } from 'vue';

const logs = ref([
    {
        pos: 0
    },
    {
        pos: 1
    }
])
</script>