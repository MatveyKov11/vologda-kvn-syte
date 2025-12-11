<template>
    <div class="ui text container">
        <h2 class="ui header">
            <div class="content">
                Конкурсы игр
            </div>
        </h2>
    </div>
    <table class="ui table">
        <thead>
            <tr><th class="center aligned">Название конкурса</th> <th class="one wide"></th>
        </tr></thead>
        <tbody>
            <tr v-for="contest in contests" :key="contest.id">
                <td>
                    <div class="ui fluid input">
                        <input type="text" name="contestName" v-model="contest.contestName">
                    </div>
                </td>
                <td><i class="minus square icon" @click="deleteRow(contest.id)"></i></td>
            </tr>
        </tbody>
    </table>
    <button class="ui button" @click="addRow">
        <i class="plus icon"></i> Добавить конкурс
    </button>
    <button class="ui button" @click="saveChanges">
        <i class="check icon"></i> Сохранить изменения
    </button>
</template>

<script setup>
import { ref } from 'vue';

const contests = ref([
    {
        id: 0,
        contestName: 'Визитка'
    },
    {
        id: 1,
        contestName: 'Разминка'
    },
    {
        id: 2,
        contestName: 'Сложная ситуация'
    },
    {
        id: 3,
        contestName: 'Музыкальное домашнее задание'
    }
])

function deleteRow(id){
    contests.value = contests.value.filter(el => el.id != id)
    for(let i = 0; i < contests.value.length; i++){
        contests.value[i].id = i
    }
}

function addRow(){
    contests.value.push({id: contests.value.length})
}

function saveChanges(){
    alert('Изменения сохранены!')
    router.push({name: 'Admin Home'})
}
</script>